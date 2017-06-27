// ==UserScript==
// @name        hantai-downloader
// @namespace    http://tampermonkey.net/
// @version      0.1
// @description  try to take over the world!
// @author       zater
//@require  https://code.jquery.com/jquery-3.2.1.min.js
// @include        https://ex.org/g/*
// @grant        none
// ==/UserScript==

(function() {
    'use strict';
    $(function(){
        $("<form method=\"post\" action=\"http:\/\/localhost:8084\/exDownloader\/DownloadEx\"><input type=\"hidden\" name=\"urlforwarding\" id=\"urlforwarding\" /></name><div id=\"urlsssssss\" disabled></div><input type=\"submit\" id=\"sumitter\" /></form>").prependTo("body");
        $("#urlforwarding").val(window.location.href);
        $("<button>download it</button>").prependTo("body").click(function(){
        $(".gdtm div a").each(
            function(index,p){
                var url= $(p).get(0).href;
                $.get(url,function(data){
                    $("#urlsssssss").append("<textarea name=\"urlinfomation\" class=\"ppppppppp\">"+data+"</textarea>");
                });
            }
        );
            $(".ppppppppp #img").each(function(index,object2){
                console.log( $(object2).get().src);
            });
            $("#sumitter").submit();
        }).css("width","1000px","height","300px");
    });
    // Your code here...
})();
