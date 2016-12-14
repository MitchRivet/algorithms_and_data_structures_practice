<?php
class Greeter
{
    private $boss;
    private $guests;
    private $name;

    function __construct($boss, $guests = array(), $name) {
        $this->boss = $boss;
        $this->guests = $guests;
        $this->name = '';
    }

    // returns welcome message for last guest
    public function greet()
    {
        var_dump($this->guests);
        $name = $this->guests[count($guests)];

        if ($this->name == $this->boss) {
            return 'Very very welcome, ' . $this->boss;
        } else {
            return 'Welcome, ' . $this->name;
        }
    }

    public function enters($name)
    {
        $this->name = $name;
        array_push($this->guests, $name);

    }
}


$g = new Greeter('Chuck');
$g->enters(2);
echo $g->greet();
