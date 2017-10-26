
import {ArrayBasedSet as _ArrayBasedSet} from "./ArrayBasedSet";
import {Set as _Set} from "./Set";

export namespace sets{
    export let ArrayBasedSet = _ArrayBasedSet;
    export type Set<Item> = _Set<Item>;
}