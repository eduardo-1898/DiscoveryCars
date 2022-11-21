    $(document).ready(function () {
        $("#txtPlaca").change(function() {
            var placa = $("#txtPlaca").val();
            if(placa!==""){
                $.ajax({
                    url: "/Api/PlacaExist",
                    data: JSON.stringify({ "placa": placa }),
                    type: 'POST',
                    contentType:'application/json',
                    success: function(data){
                        if(data==="false"){
                            swal.fire(
                                'Ups!',
                                'Este número de placa no se encuentra registrado',
                                'error'    
                            );
                        }
                    }
                });   
            }
        });
    });