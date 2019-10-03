
<?php 

  //Requesting variables from client
  $state         = $_REQUEST["state"];
  $cell_num      = $_REQUEST["cell_num"];
  $time          = strtotime($_REQUEST['time']);
  $i_cell_num    = ((int)$cell_num - 1); 
  $linestop      = (($i_cell_num * 3)+1);
  $alarm_state   = "off";

  $myfile = fopen("doorstate.txt", "r+") or die("Unable to open file!");  

  //Checks if time is a valid time.
  if($time)
  {
    $curr_time = date("H:i", $time);
  }
  else 
  {
    echo "invalid date";
  }

  //Handle case of closed and unlocked for more than 5 minutes - replace with function if time
  if($state === "closed")
  {
    for($x = 0; $x < $linestop; $x++)
    {
      $line = fgets($myfile);
    }

    $prev_state = chop(fgets($myfile)); 
  
    if($prev_state === "closed")
      {
        $prev_time = fgets($myfile);
        $t = strtotime($prev_time);
        $diff = ($time - $t)/60;

        if( $diff > 5 | $diff < 0 )
        {
          $alarm_state = "on";
        }
      }
  }

  //Handling times doors are allowed to be open - replace with function if time
  if($state == "open__");
  {
    $open_times = array("8:30", "9:00", "12:00","13:00","18:00","19:00");
    $array_length = count($open_times);

   if($state == "open__")
    {
      for($x = 0; $x < $array_length; $x+=2)
      {  
          $t1 = strtotime($open_times[$x]);
          $start_time = date("H:i", $t1);
          $t2 = strtotime($open_times[$x+1]);
          $end_time = date("H:i", $t2);
        
          if($curr_time >= $start_time && $curr_time <= $end_time)
          {
          break;
          }else $alarm_state = "on";
      }
    }
  }  
    //File pointer back to the top
    rewind($myfile);
    for($x = 0; $x < $linestop; $x++)
    {
      $line = fgets($myfile);
    }

    //overwriting previous state and time with the new state and time
    fwrite($myfile,$state."\n");
    fwrite($myfile,$curr_time."\n");
    fclose($myfile);

    //Return this status message to client
    print $alarm_state.$state;
    

    $log = fopen("doorlog.txt", "a") or die("Unable to open file!"); 
    fwrite($log,"Cell ".$cell_num." - ".$curr_time." - ".$state."- Alarm State: ".$alarm_state."\n");
    fclose($log);
?>
