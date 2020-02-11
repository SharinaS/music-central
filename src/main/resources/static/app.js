'use strict';

$(function() {
  // removes
  $('.edit-button').click(function(){
    console.log('clicked on edit button');
    $('.text-to-hide').hide();
    $('.form-to-show').removeAttr('hidden');

   });
})