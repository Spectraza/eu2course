import {INode} from './INode';
import {Constant} from './operations/Constant';
import {Add} from './operations/Add';
import {Subtract} from './operations/Subtract';
import {Multiply} from './operations/Multiply';
import {Divide} from './operations/Divide';
import {Sin} from './operations/Sin';
import {Cos} from './operations/Cos';
import {Sqrt} from './operations/Sqrt';
import {Pow} from './operations/Pow';

// class to parse math-input
export class TreeParser {
  // map from operator symbol to tools to create a node
  operators = new Map()
    .set('+', [2, (branches: INode[]) => new Add(branches)])
    .set('-', [2, (branches: INode[]) => new Subtract(branches)])
    .set('*', [2, (branches: INode[]) => new Multiply(branches)])
    .set('/', [2, (branches: INode[]) => new Divide(branches)])
    .set('sin', [1, (branches: INode[]) => new Sin(branches)])
    .set('cos', [1, (branches: INode[]) => new Cos(branches)])
    .set('sqrt', [1, (branches: INode[]) => new Sqrt(branches)])
    .set('^', [2, (branches: INode[]) => new Pow(branches)]);
  //method to parse into tree
  parse(elements: String[]): INode {
    // take last element
    let element: String = elements.pop()!;
    // try to get tools for that element
    let tools = this.operators.get(element);
    // if we have tools, this is operation, if not - constant
    if (tools !== undefined) {
      // split tools into node builder and number of operands for that operation
      let [branchN, builder] = tools;

      // we will be storing child-nodes here
      let branches = [];
      //we need to make enough for operation
      for (let i = 0; i < branchN; i++) {
        // use this method recursively and add resulting node
        branches.push(this.parse(elements));
      }
      // call builder with its child-nodes
      return builder(branches);
    }
    // create constant from element and just return it
    return new Constant(+(element as unknown as number));
  }

}

