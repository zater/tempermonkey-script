// ==UserScript==
// @name         disable killer
// @version      0.1
// @description  disable killer
// @author       zater
// @grant        none
//@require  https://code.jquery.com/jquery-3.2.1.min.js
// @include        http*
// ==/UserScript==

(function() {
    'use strict';

    $(document).ready(
function(){

    $("input[disabled]").removeAttr("disabled");
}
    );
    // Your code here...
})();
