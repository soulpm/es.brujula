class ListItem {
    constructor(name,btnAdd,btnDrop,btnUndo,promptName,promptInput,promptButtonAdd,promptButtonCancel,promptMessage) {
        this.id         = name;
        this.buttonAdd  = btnAdd;
        this.buttonDrop = btnDrop;
        this.buttonUndo = btnUndo;
        this.prompt     = {
            name                : promptName,
            input               : promptInput,
            buttonAdd           : promptButtonAdd,
            buttonCancel        : promptButtonCancel,
            validationLabel     : promptMessage
        };
        this.lastAction = 0;
        this.lastValue  = {};
        this.itemCopy   = [];
        this.items      = [];
        this.configInitial();
    }
    addItem(value) {
        var _instance = this;
        _instance.items.push(value);
        _instance.lastAction = 1;
        _instance.paint();
    }
    removeItem(value) {
        var _instance = this;
        _instance.lastAction = 2;
        _instance.lastValue  = {
            position:value,
            value:_instance.items[value]
        };
        _instance.items.splice(value,1);
        _instance.paint();
    }
    addLast(){
        var _instance = this;
        _instance.items.splice(_instance.lastValue.position, 0, _instance.lastValue.value);
        _instance.lastAction = 0;
        _instance.paint();
    }
    removeLast() {
        var _instance = this;
        _instance.items.pop();
        _instance.lastAction = 0;
        _instance.paint();
    }
    removeAll(value) {
        var _instance = this;
        _instance.lastAction    = 3;
        _instance.itemCopy      = _instance.items;
        _instance.items         = [];
        _instance.paint();
    }
    addAll(){   
        var _instance = this;
        _instance.items = _instance.itemCopy;
        _instance.lastAction = 0;
        _instance.paint();
    }

    //DOM Funcionality
    configInitial() {
        var _instance = this;
        $("." + _instance.buttonAdd).click(function () {
            //_instance.addItem("VALUE: "+Math.random());
            $("#"+_instance.prompt.name).css("display","inline");
            $("#"+_instance.prompt.input).focus();
            
            $("#"+_instance.prompt.buttonCancel).click(function(){
                $("#"+_instance.prompt.name).css("display","none");
            });
            $("#"+_instance.prompt.buttonAdd).click(function(){
               if($("#"+_instance.prompt.input).val()!=""){
                    _instance.addItem($("#"+_instance.prompt.input).val());
                    $("#"+_instance.prompt.input).val(""); 
                    $("#"+_instance.prompt.name).css("display","none");
               } 
               else
               {
                   $("#"+_instance.prompt.validationLabel).css("display","inline");
                   $("#"+_instance.prompt.validationLabel).html("Ingrese un valor para agregar...");
                   $("#"+_instance.prompt.input).focus();
                   setTimeout(() => {
                     $("#"+_instance.prompt.validationLabel).css("display","none");
                     $("#"+_instance.prompt.validationLabel).html("");
                   }, 3000);
               }
            });
        });
        $("." +_instance.buttonDrop).click(function () {
            _instance.removeAll();
        });
        $("." +_instance.buttonUndo).click(function () {
            switch(_instance.lastAction){
                case 1: //add
                    _instance.removeLast();
                break;
                case 2: //drop
                    _instance.addLast();
                break;
                case 3: //remove all
                    _instance.addAll();
                break;
                
            }
        });
    }
    paint() {
        var _instance = this;
        $("#container-list").html("");
        var _htmlValue = "";
        for (var k = 0; k < _instance.items.length; k++) {
            _htmlValue += "<div class='item-list' id='item_list_brujula_" + k + "' >" + _instance.items[k] + "</div>";
        }
        $("#container-list").html(_htmlValue);
        for (var k = 0; k < _instance.items.length; k++) {
            _instance.setDblClickAction(k);
        }
    }
    setDblClickAction(lengthValue){
        var _instance = this;
        $("#item_list_brujula_"+lengthValue).dblclick(function(){
            _instance.removeItem(lengthValue);
        });
    }


}





