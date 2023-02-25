import {INode} from '../INode';
export class Constant implements INode {
  branches: INode[] = [];

  calculate(): number {
    return this.value;
  }

  constructor(private value: number) {
  }
}
