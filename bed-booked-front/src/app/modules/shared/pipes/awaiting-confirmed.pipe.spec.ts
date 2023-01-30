import { AwaitingConfirmedPipe } from './awaiting-confirmed.pipe';

describe('AwaitingConfirmedPipe', () => {
  it('create an instance', () => {
    const pipe = new AwaitingConfirmedPipe();
    expect(pipe).toBeTruthy();
  });
});
