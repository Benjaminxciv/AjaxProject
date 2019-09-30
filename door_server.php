
<?php 

$state         = $_REQUEST["state"];
$cell_num      = $_REQUEST["cell_num"];
$time          = strtotime($_REQUEST['time']);

$i_cell_num    = ((int)$cell_num - 1); 
$linestop      = (($i_cell_num * 3)+1);
$alarm_state   = "off";

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
  $myfile = fopen("doorstate.txt", "r") or die("Unable to open file!");

  for($x = 0; $x < $linestop; $x++)
  {
    fgets($myfile);
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
    fclose($myfile); 
}

//Start of handling times doors are allowed to be open ..Only needed if state is open - replace with function if time
if($state == "open");
{
$open_times = array("8:30", "9:00", "12:00","13:00","18:00","19:00");
$array_length = count($open_times);

if($state == "open")
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

print $alarm_state;

  // $fp = fopen("doorstate.txt", "r+") or die("Unable to open file!");
  
  // for($x = 0; $x < $linestop; $x++) 
  // {
  //   fgets($myfile);
  // }

  // fwrite($fp,"test");  

  // fclose($fp);
?>
