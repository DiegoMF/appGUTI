<html lang="en">
<head>
  <meta charset="utf-8">
  <script src="//code.jquery.com/jquery-1.9.1.js"></script>
  <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
</head>

<script>
$(document).ready(function() {
	
var confirmation = $('#modal-confirmation', context).dialog({
	dialogClass:'delete_confirmation_dialog',
	autoOpen: false,
	width:400,
	minHeight:200,
	modal: true,
	resizable: false,
	buttons: {
	  'Cancel': function() {
	    // YOUR CODE
	    $(this).dialog("close");
	  },
	  'Continue': function() {
	    // YOUR CODE
	    $(this).dialog("close");
	  },
	},
	create:function () {
	  $(this).closest(".ui-dialog")
	    .find(".ui-button:eq(1)") // the second button
	    .addClass("continue");
	 }
	});
	
$('a.button').live("click", function() {
	  confirmation.dialog('open');
	  return false;
	});
}
</script>



<div style="display:none" id="modal-confirmation" title="Delete?">Are you sure you want to delete?</div> 

<a id="SOMEID" class="button" href="#">Delete?</a>

