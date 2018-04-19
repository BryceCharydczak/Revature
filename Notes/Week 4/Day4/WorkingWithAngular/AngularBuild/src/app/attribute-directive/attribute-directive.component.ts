import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'attribute-directive',
  templateUrl: './attribute-directive.component.html',
  styleUrls: ['./attribute-directive.component.css']
})
export class AttributeDirectiveComponent implements OnInit {
  colors:string[] = ["red", "blue", "green", "yellow"];
  color:string = 'color;'
  name:string;
  isDisabled:boolean = true;
  classes:string[] = ["bold", "italic", "highlight"];
  selectedClass: string[] = [];

  enabler(){
    this.isDisabled=!this.isDisabled;
  }

  addClass(event:any){
    let values = event.target.options;
    let option: any;

    for(let i = 0; i < values.length; i++){
      option = values[i];


      if(option.selected){}
      this.selectedClass.push(option.text);
    }
  }
}

