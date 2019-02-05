/**
 *Definition for an interval.
 */
function Interval(start, end) {
  this.start = start;
  this.end = end;
}

/**
 * @param {Interval[]} intervals
 * @return {number}
 */
var minMeetingRooms = function(intervals) {
  let starts = Array.from(intervals, i => i.start).sort((a, b) => a - b);
  let ends = Array.from(intervals, i => i.end).sort((a, b) => a - b);

  let currentEndIndex = 0;

  return starts.reduce((a, v) => {
    if (v < ends[currentEndIndex]) {
      return a + 1;
    } else {
      currentEndIndex++;
      return a;
    }
  }, 0);
};

let intervals = [];
intervals.push(new Interval(0, 30), new Interval(5, 10), new Interval(15, 20));

console.log(minMeetingRooms(intervals));
