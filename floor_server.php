
<?php 

  //Requesting variables variables from the client
  $input_weight   = $_REQUEST["input_weight"];
  $cellNum        = $_REQUEST["cellNum"];
  $f_input_weight = (float) $input_weight;
  $alarm_state    = "off";
  
  $cell_members_weight = array("1" => 200, "2" => 300, "3"=> 150,"4" => 180, "5" => 220);

  $difference = $f_input_weight - $cell_members_weight[$cellNum];
  if($difference > 2)
  {
    $alarm_state = "on";
  }
  
  //Return this status message to client
  print $alarm_state.$input_weight;
    // print "<p>The floor state: $alarm_state</p> ";
    // print "Current weight: $f_inputWeight"
?>
