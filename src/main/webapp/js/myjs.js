// JavaScript Document
$('#addNoItemLink').click(function(){
	var newNoItem = $('#newNoItem').val();
	var questionId = $('#questionId').val();
	$.get('addNoList',{newNoItem:newNoItem, questionId:questionId}, function(data){
		$('#noListDiv').append(data + "<br>");
	});
//	alert(newNoItem + " " + questionId);
//	$('#noListDiv').append(newNoItem + "<br>");
//	$.get('TestServlet',{input:string},function(data){
//	$('#feedback').text(data);
});

//$('#p1').click(function(){
//	$('#p1').hide();
//});
//
//$('#btnLoad').click(function(){
//	alert('hello');
//	$('#content').load('loaded.html');
//});
//
//$('.menuitem').click(function(){
////	alert(this.id);
//	if(this.id == 'homeMenu'){
//		$('#maincontent').load('home.jsp');
//	}else if(this.id == 'entrepreneurMenu'){
//		$('#maincontent').load('entrepreneur/entrepreneur.jsp');	
//	}
//});
//
////$(function() {
////    $('table tbody tr').mouseover(function() {
////       $(this).addClass('selectedRow');
////    }).mouseout(function() {
////       $(this).removeClass('selectedRow');
////    }).click(function() {
////       alert($('td:first', this).text());
////    });
//// });
//
//$(function() {
//    $('tr').click(function() {
//    	var id = $('td:first',this).text();
//    	$.get(id);
//
//    });
// });