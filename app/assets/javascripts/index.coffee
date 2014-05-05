$ ->
 $.get "/bars", (data) ->
  $.each data, (vpage3, bar) ->
   $("#bars").append $("<li>").text bar.name