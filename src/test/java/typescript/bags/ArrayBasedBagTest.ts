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

import * as typescript from '../../../../main/java/typescript/bags/bags';
import * as Chai from "chai";

describe('Basic tests', () => {
    let arrayBasedBag: typescript.bags.Bag<String>;

    beforeEach(function () {
        arrayBasedBag = new typescript.bags.ArrayBasedBag(5);
    });


    it('isEmpty test', () => {
        const result = arrayBasedBag.size();
        Chai.expect(result).to.equal(0);
    });

    it('add test', () => {
        arrayBasedBag.add("asd");
        const result = arrayBasedBag.size();
        Chai.expect(result).to.equal(1);
    });

    it('iterator test', () => {
        let expected: String = "holamundo";

        arrayBasedBag.add("hola");
        arrayBasedBag.add("mundo");
        let actual = "";

        console.log("es5 doesn't support iterators");
        // for(let el of arrayBasedBag){
        //     actual.append(el);
        // }
        // Chai.expect(expected).to.equal(actual.toString());
    });


    it('disposeItems test', () => {
        for (let i = 0; i < 5; i++) {
            arrayBasedBag.add(i+"");
        }
        Chai.expect(5).to.equal(arrayBasedBag.size());
        arrayBasedBag.disposeItems();
        Chai.expect(0).to.equal(arrayBasedBag.size());
    });


    it('forEach test', () => {
        arrayBasedBag.add("hola");
        arrayBasedBag.add("mundo");
        let list = new Array<String>(2);

        console.log("es5 doesn't support iterators");

        // list.push(...arrayBasedBag);
        // arrayBasedBag.each(e->list.push(e));
        // Chai.expect(2).to.equal(list.length);
        // Chai.expect(list[0]).to.equal(arrayBasedBag.getAtIndex(0));
        // Chai.expect(list[1]).to.equal(arrayBasedBag.getAtIndex(1));
    });



});

