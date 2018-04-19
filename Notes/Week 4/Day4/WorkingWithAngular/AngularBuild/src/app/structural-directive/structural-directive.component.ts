import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'structural-directive',
  templateUrl: './structural-directive.component.html',
  styleUrls: ['./structural-directive.component.css']
})
export class StructuralDirectiveComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}

people = ["Jack", "Jill", "Billy"]

monsters: object[] = [{
  name: "Nessie",
  location: "Loch Ness, Scotland"
},
  {
    name: "Godzilla",
    location: "Tokyo Japan"
  }
]


time: string;

changeDay(){
  this.time = 'day';
}

changeNight(){
  this.time = 'night';
}
