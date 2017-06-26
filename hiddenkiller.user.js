// ==UserScript==
// @name         hidden killer
// @version      0.1
// @description  kill hiddener
// @author       zater
// @grant        none
//@require  https://code.jquery.com/jquery-3.2.1.min.js
// @include        http*
// ==/UserScript==

(function() {
    'use strict';

    $(document).ready(
function(){

    $("input[type=hidden]").removeAttr("type").attr("type","text").html(this.val());
}    
    
    
    );
    
    // Your code here...
})();
