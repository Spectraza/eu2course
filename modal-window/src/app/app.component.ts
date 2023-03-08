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

  start_counter(){
    if (this.intervalId === null) return this.intervalId;
    this.intervalId = setInterval(() => this.increment_counter(), 1000);
  }


  increment_counter() {
    this.counter++;
    if (this.counter === 12){
      clearInterval(this.intervalId)
      this.intervalId = null;
    }
  }

}
