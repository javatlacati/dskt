/* 
 * Copyright (C) 2017 root
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * A Bag is a simple datastructure that holds items and can be emptied.
 * <code>Te hace falta ver mas bags :v</code>
 */


    export interface Bag<Item> {

        /**
         * Adds an item to the bag.
         *
         * @param item item to be added to the bag
         */
        add(item: Item): void;

        /**
         * Returns how many items it contains.
         * @return
         */
        size(): number;

        /**
         * Searches for an Item.
         *
         * @param target element to be searched
         * @return
         */
        find(target: Item): Item;

        /**
         * Makes this bag empty.
         */
        disposeItems(): void;
    }
