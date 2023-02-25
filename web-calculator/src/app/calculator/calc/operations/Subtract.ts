import {INode} from '../INode';

export class Subtract implements INode {
  branches: INode[];

  calculate(): number {
    return this.branches[0].calculate() - this.branches[1].calculate();
  }

  constructor(branches: INode[]) {
    this.branches = branches;
  }
}
