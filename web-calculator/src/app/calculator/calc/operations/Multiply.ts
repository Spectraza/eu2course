import {INode} from '../INode';

export class Multiply implements INode{
  branches: INode[];

  calculate(): number {
    return this.branches[0].calculate() * this.branches[1].calculate();
  }

  constructor(branches: INode[]) {
    this.branches = branches;
  }

}
