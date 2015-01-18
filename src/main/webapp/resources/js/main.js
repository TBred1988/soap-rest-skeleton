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

    $('ul.options li.option-item a#show-items').click(function(){
        $.ajax({
            url: "/services/rest/items-service/items/list-all",
            data: "",
            contentType : "application/json",
            dataType : "json",
            success:function(data, textStatus, xhr){
                if(xhr.status == 200){
                    //iterate over the items array
                    var itemsHTML = '';
                    var itemsContainer = $('div#items-container');
                    itemsHTML += '<ul class="items-result">';
                    $.each(data.items,function(actItemIndex,actItemJsonValue){
                        itemsHTML += '<li>';
                        $.each(actItemJsonValue,function(actKey,actValue){
                            itemsHTML += '<p>';
                            itemsHTML += actKey + ': ' + '<span>'+actValue+'</span>';
                            itemsHTML += '</p>';
                        });
                        itemsHTML += '</li>';
                    });
                    itemsHTML += '</ul>';
                    itemsContainer.html(itemsHTML);
                    itemsContainer.show();
                    $('div#items-popup').show();
                }else{
                    alert('Error occurred during the items listing');
                }
            }
        }).done(function() {
            });
    });

    $('a.close').click(function(){
        $(this).parent().hide();
    });

});