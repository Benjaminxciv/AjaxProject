<html>
  <body>
<?php 

  $open_times = array("8:30", "9:00", "12:00","13:00","18:00","19:00");
  $array_length = count($cars);
  // $bf_start     = new DateTime("8:30");
  // $bf_end       = new DateTime("9:00");
  // $lunch_start  = new DateTime("12:00");
  // $lunch_end    = new DateTime("13:00");
  // $dinner_start = new DateTime("18:00");
  // $dinner_end   = new DateTime("19:00");
  

  $time = strtotime($_GET['time']);
  if($time){
  $curr_time = date("H:i", $time);
  }else{
    echo "invalid date";
  }

//   for($x = 0; $x < $array_length; $x++) {
//    // $temp_time1 = new DateTime($open_times[$x]);
//     echo $open_times[$x];
// }

  
  $state = $_REQUEST["state"];
  
  echo $curr_time;
  print "<p>The door is: $state</p> ";
?>

</body>
</html>