org_vaadin_addons_Toastr = function() {
    var debug = true;
    var connector = this;
    toastr.options.onShown=function () {
        connector.onShown();
    };
    toastr.options.onHidden=function () {
        connector.onHidden();
    };
    toastr.options.onclick=function () {
        connector.onClick();
    };
    toastr.options.onCloseClick=function () {
        connector.onCloseClick();
    };
    this.clear = function () {
        toastr.clear();
    };
    this.remove = function () {
        toastr.remove();
    };
    this.vaadinToastr = function(type, message, caption, options) {
        if (debug === true) {
            console.log(options);
        }
        toastr[type](message, caption, jQuery.parseJSON(options));
    };
};