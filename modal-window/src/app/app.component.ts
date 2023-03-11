import {Component, Inject} from '@angular/core';
import {MatDialog, MAT_DIALOG_DATA} from '@angular/material/dialog';



export interface DialogData {

}
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'modal-window';


  constructor(public dialog: MatDialog) {}

//   function of opening modal dialog
  openDialog() {
    this.dialog.open(DialogDataTest, {
      data: {
      },
    });
  }
}

@Component({
  selector: 'dialog-data-test',
  templateUrl: 'dialog-data-test.html',
})

export class DialogDataTest{
  counter = 0;
  intervalId: any;
  constructor(@Inject(MAT_DIALOG_DATA) public data: DialogData) {}

  
//  create a function to start counting after clicking on button
  start_counter(){
    if (this.intervalId === null) return this.intervalId;
    this.intervalId = setInterval(() => this.increment_counter(), 1000);
  }

// when counter reaching a number 15, it will stop
  increment_counter() {
    this.counter++;
    if (this.counter === 15){
      clearInterval(this.intervalId)
      this.intervalId = null;
    }
  }

}
