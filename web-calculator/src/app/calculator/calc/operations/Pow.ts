import {INode} from '../INode';

export class Pow implements INode{
  branches: INode[];

  calculate(): number {
    return Math.pow(this.branches[0].calculate(), this.branches[1].calculate());
  }

  constructor(branches: INode[]) {
    this.branches = branches;
  }

}
