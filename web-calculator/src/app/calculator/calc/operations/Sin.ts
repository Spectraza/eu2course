import {INode} from '../INode';

export class Sin implements INode{
  branches: INode[];

  calculate(): number {
    return Math.sin(this.branches[0].calculate());
  }

  constructor(branches: INode[]) {
    this.branches = branches;
  }

}
