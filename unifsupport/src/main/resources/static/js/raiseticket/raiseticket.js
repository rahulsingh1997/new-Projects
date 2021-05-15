
function raiseticket()
{
    var form = $("#RAISETICKETFORM")[0];
    var data = new FormData(form);

    $.ajax({
        url: "/raiseticket/raisenewticket",
        type: "POST",
        enctype: "multipart/form-data",
        data: data,
        cache: false,
        contentType:false,
        processData: false,
        timeout:600000,
        success: function(data){

            alert(data);
            //$('#replace_div').html(data);

            if( res=="Success" )
            {
                bootbox.alert({
                    size: 'medium',
                    title:'<i class="fa fa-check" style="font-size:25px; color:green;">&nbsp;&nbsp;Success</i>',
                    message:"Document successfully uploaded."
                });
            }
            else if( res=="MISMATCH" )
            {
                //alert("MISMATCH");
                bootbox.alert({
                    size: 'medium',
                    title:'<i class="fa fa-times-circle" style="font-size:25px; color:red;">&nbsp;&nbsp;Error</i>',
                    message:"Mismatch."
                });
            }
            else if( res=="EMPTY_FILE" )
            {
                //alert("File is empty");
                bootbox.alert({
                    size: 'medium',
                    title:'<i class="fa fa-times-circle" style="font-size:25px; color:red;">&nbsp;&nbsp;Error</i>',
                    message:"File is empty."
                });
            }
            else if( res=="WRITE_ERROR" )
            {
                //alert("Error in writing file.");
                bootbox.alert({
                    size: 'medium',
                    title:'<i class="fa fa-times-circle" style="font-size:25px; color:red;">&nbsp;&nbsp;Error</i>',
                    message:"Error in writing file."
                });
            }
            else if( res=="IOEXCEPTION" )
            {
                //alert("IO Exception has occurred.");
                bootbox.alert({
                    size: 'medium',
                    title:'<i class="fa fa-times-circle" style="font-size:25px; color:red;">&nbsp;&nbsp;Error</i>',
                    message:"IO Exception has occurred."
                });
            }
            else if( res=="LOG_ERROR" )
            {
                //alert("Error while logging file info.");
                bootbox.alert({
                    size: 'medium',
                    title:'<i class="fa fa-times-circle" style="font-size:25px; color:red;">&nbsp;&nbsp;Error</i>',
                    message:"Error while logging file info."
                });
            }
            else if( res=="ILLEGALARG" )
            {
                bootbox.alert({
                    size: 'medium',
                    title:'<i class="fa fa-times-circle" style="font-size:25px; color:red;">&nbsp;&nbsp;Error</i>',
                    message:"Error while posting file log."
                });
            }
        },
        error: function(data){
            alert("ERROR : "+JSON.stringify(data));
        }
    });
}
