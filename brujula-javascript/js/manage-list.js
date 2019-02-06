$(document).ready(function() {
    
    var listItem = new ListItem(
        "container-list",
        "btn-add",
        "btn-drop",
        "btn-undo",
        "prompt-list",
        "txt-prompt-input",
        "btn-prompt-input-add",
        "btn-prompt-input-close",
        "message-validation-prompt"
    );

   
    $.mockjax({
        url: '/brujula/list-initial-items',
        type: 'GET',
        response: function() {
            this.responseText = { listInitial:["Valor "+Math.random(),"Valor "+Math.random(),"Valor "+Math.random()] };
        }
    });

    $.ajax({
        url: '/brujula/list-initial-items',
        success: function(data) {
            var itemsInit = data;
            for(var k=0;k<itemsInit.listInitial.length;k++){
                listItem.addItem(itemsInit.listInitial[k]);
            }
        }
    });


});

