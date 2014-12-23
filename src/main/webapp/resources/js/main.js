$(document).ready(function(){

    $('#login-button').click(function(){
        $.ajax({
            url: "/web/ajax/login",
            data: "email="+$('#email').val()+"&password="+$('#password').val(),
            contentType : "application/json",
            dataType : "json",
            success:function(result){
                if(result.statusCode == 200){
                    $('form[name="login"]').submit();
                }
            }
        }).done(function() {
            });
    });

});