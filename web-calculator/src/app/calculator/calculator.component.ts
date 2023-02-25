import {Component, OnInit} from '@angular/core';
import {Constant} from './calc/operations/Constant';
import {Subtract} from './calc/operations/Subtract';
import {Add} from './calc/operations/Add';
import {Sin} from './calc/operations/Sin';
import {FormControl, Validators} from '@angular/forms';
import {TreeParser} from './calc/TreeParser';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css'],
})
export class CalculatorComponent implements OnInit {
  // add form control get input and validate it
  math = new FormControl('+ 2 2', [Validators.required]);
  // variable to hold a calculation result
  value: number | null = null;
  // this will convert input to tree
  parser = new TreeParser();

  constructor() {
  }

  ngOnInit(): void {
  }

  // calculate math
  calculate() {
    // calculate only if math is valid
    if (this.math.valid) {

      // get each element
      let elements = this.math.value.split(' ').reverse();
      // parse elements into root-node
      let tree = this.parser.parse(elements);
      // calculate tree
      this.value = tree.calculate();
    }
  };
}

