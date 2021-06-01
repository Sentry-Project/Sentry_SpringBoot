function getRoom(rid){
    $('#adddevice_but').attr('currId', rid);
    $.ajax({
        url: 'getSensor',
        data: {rid: rid},
        success: function (data){
            getDevice(rid);
            let results;
            let sen_r;
            $("#sensorResultsBlock").empty();

            for (let i=0; i < data.length; i++){
                console.log(data[i].sensorType);
                if(data[i].sensorType =="Temperature"){
                    sen_r='<i id="block_img1" class="fas fa-temperature-low fa-4x"></i>';
                
                }else if(data[i].sensorType =="Water"){
                    sen_r='<i id="block_img1" class="fas fa-tint fa-4x"></i>';
                
                }else{
                   sen_r='<i id="block_img1" class="fas fa-wind fa-4x"></i>';
                
                };
                results = '<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 py-2">' +
                    '<div class="temperature">' +
                    '<div class="tempara">' +
                  //  '<img class="block_img1"  src="../images/Temperature.png"/>' +
                    sen_r+
                    '<div class="block text">' +
                    '<p class="block_text">fix 24&#8451</p>' +
                    '</div>' +
                    '<img class="block_Setting"  src="../images/Settings.png" />' +
                    '</div>' +
                    '<div  class="onoff">fix On</div>' +
                    '<div class="zone"> ' +
                     data[i].sensorType +
                    '</div>' +
                    '</div>' +
                    '</div>' +
                    '</div>';

                $("#sensorResultsBlock").append(results);


            }



            // console.log(data);
        } ,
        error: function (e){
            console.log(e);
        }
    });
}

function getDevice(rid){
    $.ajax({
        url: 'getDevice',
        data: {rid: rid},
        success: function (deviceData){
            let result2;
            $("#deviceResultsBlock").empty();
            for (let i=0; i < deviceData.length; i++){
                //console.log(deviceData[i]);
				if(deviceData[i].deviceStatus== 1){
                   var str="on";               
                }else{
                   var str="off"; 
                }
                result2 = '<span>' +
                    '<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 py-2" >' +
                    '<div class="device_card">' +
                    ' <div class="tempara">' +
                   '<img class="block_img" src="../images/Machine.png" />' +
                    '<div class="block text">' +
                    '<p class="block_text"></p>' +
                    '</div>' +
                    '<img class="block_Setting" src="../images/Settings.png" />'+
                    '</div>' +
                    '<div  class="onoff"> '+ str+'</div>' +
                    '<div class="zone">' +
                    '<span hidden>' +
                    deviceData[i].id +
                    '</span>' +

                    deviceData[i].deviceName +
                    '</div>'  +
                    '</div>' +
                    '</div>' ;
                $("#deviceResultsBlock").append(result2);

            }


            // console.log(data);
        } ,
        error: function (e){
            console.log(e);
        }
    });
}

$(function (){
    $("#deviceForm").submit(function (e){
        e.preventDefault();
        let rid = $("#adddevice_but").attr('currId');
        if (rid == null){
            alert("Please select Room");
        } else{
            let formData = $("#devName").val();
            $.ajax({
                type: "POST",
                url: "saveDevice",
                data: {rid: rid, device_name: formData},
                success: function (data){
                    getDevice(rid);
                    console.log("success");
                },
                error: function (e){
                    console.log(e);
                }
            })

        }
        //alert("HEllo bruh")
    })
});






// data.forEach((obj) =>{
//     Object.keys(obj).forEach((key) => {
//         if (key == sensorName || key == room){
//             console.log("key : " + key + " - value : " + obj[key]);
//         }else {
//             return;
//         }
//
//     })
// })