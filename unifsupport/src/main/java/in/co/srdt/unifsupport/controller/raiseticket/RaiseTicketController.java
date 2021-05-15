package in.co.srdt.unifsupport.controller.raiseticket;

import in.co.srdt.unifsupport.config.AccessToken;
import in.co.srdt.unifsupport.controller.SingleResponseModel;
import in.co.srdt.unifsupport.model.raiseticket.RaiseTicketModel;
import in.co.srdt.unifsupport.utils.ApplicationGateway;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.SmartValidator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/raiseticket")
public class RaiseTicketController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ApplicationGateway appgateway;

    @RequestMapping("/manageraiseticket")
    public String manageraiseticket() {

        HttpHeaders headers=new HttpHeaders();
        headers.add("Authorization", AccessToken.getAccessToken());
        headers.setContentType(MediaType.APPLICATION_JSON);

        return "fragments/raiseticket/raiseticket :: raisenewticket";
    }



    @ResponseBody
    @RequestMapping(value = "/raisenewticket", method = RequestMethod.POST)
    public String raisenewticket(@RequestParam("issuefile") MultipartFile file, RaiseTicketModel raiseTicket, Model model, Authentication authentication) {

        HttpHeaders headers=new HttpHeaders();
        headers.add("Authorization", AccessToken.getAccessToken());
        headers.setContentType(MediaType.APPLICATION_JSON);

        //System.out.println("Inside Document Save Controller");

        String location = "/SupportDocs/RaisedTicket/"+authentication.getName();
        String filePath = new File("").getAbsolutePath()+File.separator+location;
        String storePath=location;

        if(!file.isEmpty()) {
            //CREATE DIRECTORY IF NOT EXISTS
            File dir = new File(filePath);
            if( !dir.exists() )
            {
                dir.mkdirs();
            }

            //WRITE FILES TO DIRECTORY AND ENTRY INTO THE DATABASE

            try
            {

                String empl=authentication.getName();

                String extension =  FilenameUtils.getExtension( file.getOriginalFilename() );

                String generatedFileName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss"+"'"+empl+"."+extension+"'").format(new Date());

                File target = new File(filePath+File.separator+generatedFileName);
                int readByteCount = 0;
                byte[] buffer = new byte[20480];

                BufferedInputStream in= new BufferedInputStream(file.getInputStream());
                FileOutputStream out = new FileOutputStream(target);
                while( (readByteCount = in.read(buffer)) != -1)
                {
                    out.write(buffer, 0, readByteCount);
                }
                storePath += "/"+generatedFileName;

                raiseTicket.setAttachment(storePath);

            }
            catch(IOException e)
            {
                e.printStackTrace();
                //model.addAttribute("res", "IOEXCEPTION");
                //return docRecord(model,authentication);
            }
            catch(IllegalArgumentException e)
            {
                e.printStackTrace();
                //model.addAttribute("res", "ILLEGALARG");
                //return docRecord(model,authentication);
            }
            catch(Exception e)
            {
                e.printStackTrace();
                //model.addAttribute("res", "WRITE_ERROR");
                //return docRecord(model,authentication);
            }

        }else {
            raiseTicket.setAttachment(null);
        }

        raiseTicket.setCreatedby(authentication.getName());
        System.out.println(raiseTicket.toString());

        String url = appgateway.getAppgateway()+"/support/saveRaisearequest";


        SingleResponseModel msg = null;
        HttpEntity<RaiseTicketModel> request1 = new HttpEntity<RaiseTicketModel>(raiseTicket,headers);
        ResponseEntity<SingleResponseModel> response= restTemplate.exchange(url ,HttpMethod.POST,request1, SingleResponseModel.class);
        if(response.getStatusCode() == HttpStatus.OK) {
            msg = response.getBody();
        } else {
            return "LOG_ERROR";
        }
        storePath = location;

        model.addAttribute("res", "Success");
        return msg.getStatus();
    }

}


