function searchCustomer(){
    var dni = $("#txtDNISearch").val();
    if(dni === "" || dni === null){
        swal.fire(
            'Ups!',
            'Aun no has digitado ninguna cedula',
            'error'    
        );
    }
    else{
        $.ajax({
            url: "/Api/SearchCustomer",
            data: JSON.stringify({ "cedula": dni }),
            type: 'POST',
            contentType:'application/json',
            success: function(data){
                if(data===null || data==="" ){
                    swal.fire(
                        'Ups!',
                        'Este cliente no se encuentra registrado',
                        'error'    
                    );
                }
                else{
                    $("#txtDNISearch").val("");
                    $("#txtDNI").val(dni);
                    $("#txtName").val(data.nombreCliente +" "+ data.apellido1 + " "+ data.apellido2);
                    $("#txtEmail").val(data.correo);
                    swal.fire(
                        'Éxito!',
                        'Cliente encontrado con exito',
                        'success'    
                    );
                }
            }
        });
    }
}

function searchVehicle(){
    
    var placa = $("#txtPlacaSearch").val();
    if(placa === "" || placa === null){
        swal.fire(
            'Ups!',
            'Aun no has digitado ninguna placa de vehiculo',
            'error'    
        );
    }
    else{
        $.ajax({
            url: "/Api/SearchVehicle",
            data: JSON.stringify({ "placa": placa }),
            type: 'POST',
            contentType:'application/json',
            success: function(data){
                if(data===null || data==="" ){
                    swal.fire(
                        'Ups!',
                        'Este vehiculo no se encuentra registrado',
                        'error'    
                    );
                }
                else{
                    debugger;
                    $("#txtPlacaSearch").val("");
                    $("#txtPlaca").val(placa);
                    $("#txtMarca").val(data.marcas.marca);
                    $("#txtModelo").val(data.modelos.modelo);
                    $("#txtAño").val(data.ano);
                    $("#txtEstado").val( (data.estado) ? "Disponible" : "No disponible");
                    swal.fire(
                        'Éxito!',
                        'Vehiculo encontrado con éxito',
                        'success'    
                    );
                }
            }
        });
    }
}
