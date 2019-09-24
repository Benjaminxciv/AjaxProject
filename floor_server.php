<?php 
  
  $inputWeight = $_REQUEST["inputWeight"];
  $f_inputWeight = (float) $inputWeight;

  $cellNum = $_REQUEST["cellNum"];

 $weights = array("1" => 200, "2" => 300, "3"=> 400,"4" => 500, "5" => 200);

 $difference = $f_inputWeight - $weights[$cellNum];
  
 if($difference > 2){
   $state = "ALARM";
 }

  else {
    $state = "All good";
  }

    print "<p>The floor state: $state</p> ";

?>
