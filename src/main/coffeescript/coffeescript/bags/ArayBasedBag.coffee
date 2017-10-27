# Define namespace unless it already exists
coffescript.bags or= {}

class coffescript.bags.ArrayBasedBag
  constructor: (@capacity) ->
    @internalArray = new Array(@capacity)
    @topPosition = 0

  add: (item) ->
    if @internalArray.length > @topPosition
      @internalArray[@topPosition++] = item;
    else
      throw new RangeError("Capacity overflow");

  getAtIndex: (index) ->
    @internalArray[index]

  isEmpty: () ->
    @topPosition == 0

  disposeItems: ->
    @internalArray = new Array(@internalArray.length)
    @topPosition = 0

  size: ->
    @topPosition

  find: (target) ->
    index = @internalArray.indexOf(target)
    return if index == -1 then null else this.internalArray[index]