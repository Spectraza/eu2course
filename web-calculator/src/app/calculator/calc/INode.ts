// general interface for each tree node, which can calculate itself
export interface INode {
  branches: INode[];

  calculate(): number;
}
