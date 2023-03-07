import {Component, Inject} from '@angular/core';
import {MatDialog, MAT_DIALOG_DATA} from '@angular/material/dialog';

export interface DialogData {
  animal: 'panda' | 'unicorn' | 'lion';
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
        animal: 'panda',
      },
    });
  }
}

@Component({
  selector: 'dialog-data-test',
  templateUrl: 'dialog-data-test.html',
})

export class DialogDataTest{
  constructor(@Inject(MAT_DIALOG_DATA) public data: DialogData) {}
}
