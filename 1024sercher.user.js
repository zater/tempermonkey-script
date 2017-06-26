// ==UserScript==
// @name         1024searcher
// @namespace    http://tampermonkey.net/
// @version      0.1
// @description  try to take over the world!
// @author       zater
//@require  https://code.jquery.com/jquery-3.2.1.min.js
// @include *1024.com/thread0806.php*
// @grant        none
// ==/UserScript==


(function() {
    'use strict';

    $(document).ready(function(){
        
        
        
  $  ("<input type=\"button\" id=\"click1\" value=\"searchall\"></input>")   .prependTo( $("body")).click(
      
      
      
      
        function(){
            var url = "thread0806.php";
            for(var page=1;page<=50;page++){

            var params = {"fid":getUrlParam("fid"), "page":page};
           // alert(getUrlParam("fid"));
            $.get(url,params,function(data){
                               console.log("page"+params.page);
          $("#pppppppppppppppppppppppppppppppppppp").html(data);
                   $("#pppppppppppppppppppppppppppppppppppp #ajaxtable .tr3").each(function(index,target){
                var $parser=$(target).find("h3").children();
                console.log($parser.get(0).href+" "+$parser.html());
            });
            });
       }
        }).css("width","1000px","height","300px");
   $  ("<div id=\"pppppppppppppppppppppppppppppppppppp\" display=\"none\" </div>")   .prependTo( $("body"));
    
    
    }
  );
    
    
    
    
    
    
     function getUrlParam(name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); 
            var r = window.location.search.substr(1).match(reg); 
            if (r != null) return unescape(r[2]); return null;
        }
    // Your code here...
})();
