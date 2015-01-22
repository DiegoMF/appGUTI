<jsp:include page="../masterpage/superior.jsp" />
<head>
<title>Consulta de aplicaciones especializadas</title>
<script LANGUAGE="JavaScript">
<!--
// Control flags for list selection and sort sequence
// Sequence is on option value (first 2 chars - can be stripped off in form processing)
// It is assumed that the select list is in sort sequence initially
var singleSelect = true;  // Allows an item to be selected once only
var sortSelect = true;  // Only effective if above flag set to true
var sortPick = true;  // Will order the picklist in sort sequence

// Initialise - invoked on load
function initIt() {
  var selectList = document.getElementById("SelectList");
  var selectOptions = selectList.options;
  var selectIndex = selectList.selectedIndex;
  var pickList = document.getElementById("PickList");
  var pickOptions = pickList.options;
  pickOptions[0] = null;  // Remove initial entry from picklist (was only used to set default width)
  if (!(selectIndex > -1)) {
    selectOptions[0].selected = true;  // Set first selected on load
    selectOptions[0].defaultSelected = true;  // In case of reset/reload
  }
  selectList.focus();  // Set focus on the selectlist
}

// Adds a selected item into the picklist
function addIt() {
  var selectList = document.getElementById("SelectList");
  var selectIndex = selectList.selectedIndex;
  var selectOptions = selectList.options;
  var pickList = document.getElementById("PickList");
  var pickOptions = pickList.options;
  var pickOLength = pickOptions.length;
  // An item must be selected
  while (selectIndex > -1) {
    pickOptions[pickOLength] = new Option(selectList[selectIndex].text);
    pickOptions[pickOLength].value = selectList[selectIndex].value;
    // If single selection, remove the item from the select list
    if (singleSelect) {
      selectOptions[selectIndex] = null;
    }
    if (sortPick) {
      var tempText;
      var tempValue;
      // Sort the pick list
      while (pickOLength > 0 && pickOptions[pickOLength].value < pickOptions[pickOLength-1].value) {
        tempText = pickOptions[pickOLength-1].text;
        tempValue = pickOptions[pickOLength-1].value;
        pickOptions[pickOLength-1].text = pickOptions[pickOLength].text;
        pickOptions[pickOLength-1].value = pickOptions[pickOLength].value;
        pickOptions[pickOLength].text = tempText;
        pickOptions[pickOLength].value = tempValue;
        pickOLength = pickOLength - 1;
      }
    }
    selectIndex = selectList.selectedIndex;
    pickOLength = pickOptions.length;
  }
  selectOptions[0].selected = true;
}

// Deletes an item from the picklist
function delIt() {
  var selectList = document.getElementById("SelectList");
  var selectOptions = selectList.options;
  var selectOLength = selectOptions.length;
  var pickList = document.getElementById("PickList");
  var pickIndex = pickList.selectedIndex;
  var pickOptions = pickList.options;
  while (pickIndex > -1) {
    // If single selection, replace the item in the select list
    if (singleSelect) {
      selectOptions[selectOLength] = new Option(pickList[pickIndex].text);
      selectOptions[selectOLength].value = pickList[pickIndex].value;
    }
    pickOptions[pickIndex] = null;
    if (singleSelect && sortSelect) {
      var tempText;
      var tempValue;
      // Re-sort the select list
      while (selectOLength > 0 && selectOptions[selectOLength].value < selectOptions[selectOLength-1].value) {
        tempText = selectOptions[selectOLength-1].text;
        tempValue = selectOptions[selectOLength-1].value;
        selectOptions[selectOLength-1].text = selectOptions[selectOLength].text;
        selectOptions[selectOLength-1].value = selectOptions[selectOLength].value;
        selectOptions[selectOLength].text = tempText;
        selectOptions[selectOLength].value = tempValue;
        selectOLength = selectOLength - 1;
      }
    }
    pickIndex = pickList.selectedIndex;
    selectOLength = selectOptions.length;
  }
}

// Selection - invoked on submit
function selIt(btn) {
  var pickList = document.getElementById("PickList");
  var pickOptions = pickList.options;
  var pickOLength = pickOptions.length;
  if (pickOLength < 1) {
    alert("No Selections in the Picklist\nPlease Select using the [->] button");
    return false;
  }
  for (var i = 0; i < pickOLength; i++) {
    pickOptions[i].selected = true;
  }
  return true;
}

//-->
</SCRIPT>
</head>

<div class="formulario">
    <h2>Configuración de Accesos</h2>
    <form NAME="theform" ID="theform" ACTION="whatever" onSubmit="return selIt();">
        <table bgcolor="#FFFFFF" width="1265" height="65%" border="0" cellspacing="0" cellpadding="0">
            <td>
            <table>
                <tr>
                    <td>Roles:</td>
                    <td>Pantallas:</td>
                    <td>
			<select id="pantallas" name="D3">
                            <option>Seleccionar</option>
                            <option>Reportes</option>
			</select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <select NAME="SelectList" ID="SelectList" SIZE="5" multiple="multiple" style="width: 150px">
                            <option VALUE="01sel">Asesor</option>
                            <option VALUE="02sel">Administrador</option>
                            <option VALUE="03sel">Supervisor</option>
                        </select>
                    </td>
                    <td>
                        <input TYPE="BUTTON" VALUE="->" ONCLICK="addIt();"></input>
			<br/>
			<input TYPE="BUTTON" VALUE="<-" ONCLICK="delIt();"></input>
                    </td>
                    <td>
                        <select NAME="PickList" ID="PickList" SIZE="5" multiple="multiple" style="width: 150px">
                            <option VALUE="01sel">Asesor</option>
                        </select>
                    </td>
                </tr>  
            </table>
            </td>
            <td>
         
            </td>
	</table>
       
        <table>
            <td colspan="8" style="background-color: #C0C0C0">
                <input type= "submit" name="grabar" value= "Grabar"></input>
            </td>
        </table>     
    </form>  
</div>
<jsp:include page="../masterpage/inferior.jsp" />