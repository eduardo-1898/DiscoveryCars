function searchCustomer(){
    for (var i = 0; i < 30; i++) {
        $("#listCars").remove();
    }
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
                    $("#txtIdCliente").val(data.id);
                    $("#txtDNI").val(dni);
                    $("#txtName").val(data.nombreCliente +" "+ data.apellido1 + " "+ data.apellido2);
                    $("#txtEmail").val(data.correo);
                    getSalesByClient(data.id);
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

function getSalesByClient(id){
    for (var i = 0; i < 30; i++) {
        $("#listCars").remove();
    }
    var shoppingstr = "<div id='listCars' class='row'><div class='col-12 mt-2'><label style='font-size: 10px; font-weight: bold;'>{0}</label></div><div class='col-12'><label style='font-size: 9px; color:green'>Precio: {1}</label><button onclick='deleteSale({2})' class='btn btn-danger float-end mb-2'><i class='fas fa-trash'></i></button></div><div class='col-12'></div><hr></div>";
    $.ajax({
        url: "/Api/GetShoppingCart",
        data: JSON.stringify({ "cliente": id }),
        type: 'POST',
        contentType:'application/json',
        success: function(data){
            $.each(data, function(index, value){
                var newStr = shoppingstr;
                newStr = newStr.replace("{0}", value.vehiculo.marcas.marca +" " + value.vehiculo.modelos.modelo + " " +value.vehiculo.ano + " "+value.vehiculo.placa);
                newStr = newStr.replace("{1}", value.vehiculo.precio_Compra.toLocaleString("en"));
                newStr = newStr.replace("{2}", value.id);
                $("#conteiner-sales").append(newStr);
            });
        }
    });
}

function addShoppingCart(){
    let date = new Date();
    var cliente = $("#txtIdCliente").val();
    var placa = $("#txtPlaca").val();
    var fecha = date.getDate();
    if($("#txtPlaca").val() === "" || $("#txtIdCliente").val() === ""){
        swal.fire(
            'Ups!',
            'No has definido datos suficientes para asociar el vehiculo',
            'error'    
        );
    }else{
        $.ajax({
            url: "/Api/AddShoppingCart",
            data: JSON.stringify({ "Cliente": cliente, "placa": placa, "fecha_ingreso": fecha, "Estado":'ACTIVO' }),
            type: 'POST',
            contentType:'application/json',
            success: function(data){
                getSalesByClient(cliente);
                swal.fire(
                    'Éxito!',
                    'Se ha agregado el vehículo con exito',
                    'success'    
                );
            }
        });   
    }
}

function addSale(){
    var cliente = $("#txtIdCliente").val();
    $.ajax({
        url: "/Api/AddSale",
        data: JSON.stringify({ "Cliente": cliente }),
        type: 'POST',
        contentType:'application/json',
        success: function(data){
            swal.fire(
                'Éxito!',
                'Se ha generado la venta correctamente',
                'success'    
            );
            for (var i = 0; i < 30; i++) {
                $("#listCars").remove();
            }
        }
    });
}

function deleteSale(id){
    var cliente = $("#txtIdCliente").val();
    $.ajax({
        url: "/Api/DeleteShoppingCart",
        data: JSON.stringify({ "cliente": id }),
        type: 'POST',
        contentType:'application/json',
        success: function(data){
            swal.fire(
                'Éxito!',
                'Reservación de vehiculo eliminada con exito',
                'success'    
            );
            getSalesByClient(cliente);
        }
    });
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
                else if(data.estado){
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
                else{
                    swal.fire(
                        'Ups!',
                        'Este vehiculo no se encuentra disponible para venta, ya ha sido vendido',
                        'error'    
                    );
                }
            }
        });
    }
}
