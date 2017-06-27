// ==UserScript==
// @name        exloginer
// @namespace    http://tampermonkey.net/
// @version      0.1
// @description  try to take over the world!
// @author       You
// @match        https://exhentai.org/
//@require  https://code.jquery.com/jquery-3.2.1.min.js
// @grant        none
// ==/UserScript==

(function() {
    'use strict';
    $(function(){
        var pass="pass_hash";
        var member="member_id";
        $("<input type=\"text\" id=\"member\"  value=\""+member+"\"></input>").appendTo("body").click(function(){
            $(this).val("");
        });
        $("<input type=\"text\" id=\"pass\" value=\""+pass+"\"></input>").appendTo("body").click(function(){
            $(this).val("");
        });
        $("<button name=\"login\">login</button>").appendTo("body").click(function(){
           pass=$("#pass").val();
            member=$("#member").val();
         delCookie("yay");
            setCookie("ipb_member_id",member,999);

            setCookie("ipb_pass_hash",pass,999);
window.location.reload(); 
        });

    });
    
    function delCookie(name)  
{  
    var exp = new Date();  
    exp.setTime(exp.getTime() - 1);  

        document.cookie= name + "=louder"+";expires="+exp.toGMTString();  
}  
    
    
    function setCookie(cname, cvalue, exdays) {  
    var d = new Date();  
    d.setTime(d.getTime() + (exdays*24*60*60*1000));  
    var expires = "expires="+d.toUTCString();  
    document.cookie = cname + "=" + cvalue + "; " + expires;  
}  
    
    
    // Your code here...
})();
