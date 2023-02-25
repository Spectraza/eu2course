import {INode} from '../INode';

export class Cos implements INode{
  branches: INode[];

  calculate(): number {
    return Math.cos(this.branches[0].calculate());
  }

  constructor(branches: INode[]) {
    this.branches = branches;
  }

}
