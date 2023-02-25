import {INode} from '../INode';

export class Sqrt implements INode{
  branches: INode[];

  calculate(): number {
    return Math.sqrt(this.branches[0].calculate());
  }

  constructor(branches: INode[]) {
    this.branches = branches;
  }

}
