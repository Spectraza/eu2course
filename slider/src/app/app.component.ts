import {Component} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'slider';
  currentPage = 0;
  pages = [
    {name: "tab 1", content: "lorem"},
    {name: "tab 2", content: "lorem"},
    {name: "tab 3", content: "lorem"},
    {name: "tab 4", content: "lorem"}
  ];

  test(){
    console.log(this.currentPage)
  }
}
