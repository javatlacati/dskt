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

import * as BagPackage from '../../../../main/java/typescript/bags/bags';
import * as Chai from "chai";

describe('Basic tests', () => {
    it('emptyness test', () => {
        let arrayBasedBag: BagPackage.bags.Bag<String> = new BagPackage.bags.ArrayBasedBag(5);
        const result = arrayBasedBag.size();
        Chai.expect(result).to.equal(0);
    });

    it('add test', () => {
        let arrayBasedBag: BagPackage.bags.Bag<String> = new BagPackage.bags.ArrayBasedBag(5);
        arrayBasedBag.add("asd");
        const result = arrayBasedBag.size();
        Chai.expect(result).to.equal(1);
    });



});

