
<?php 
  
  $alarm_state = "off";

  $input_weight = $_REQUEST["input_weight"];
  //echo $input_weight;
  $f_input_weight = (float) $input_weight;
  
  $cellNum = $_REQUEST["cellNum"];

 $weights = array("1" => 200, "2" => 300, "3"=> 150,"4" => 180, "5" => 220);

 $difference = $f_input_weight - $weights[$cellNum];
 
 if($difference > 2){
   $alarm_state = "on";
 }
 
  

 print $alarm_state.$input_weight;

    // print "<p>The floor state: $alarm_state</p> ";
    // print "Current weight: $f_inputWeight"
?>
