
<?php 

  //Requesting variables variables from the client
  $input_weight   = $_REQUEST["input_weight"];
  $cell_num        = $_REQUEST["cellNum"];
  $f_input_weight = (float) $input_weight;
  $alarm_state    = "off";
  
  $cell_members_weight = array("1" => 200, "2" => 300, "3"=> 150,"4" => 180, "5" => 220);

  $difference = $f_input_weight - $cell_members_weight[$cell_num];
  if($difference > 2)
  {
    $alarm_state = "on";
  }
  
  //Return this status message to client
  print $alarm_state.$input_weight;
  
  $log = fopen("floorlog.txt", "a") or die("Unable to open file!"); 
  fwrite($log,"Cell ".$cell_num." - Weight: ".$input_weight."lbs - Alarm State: ".$alarm_state."\n");
  fclose($log);
?>
