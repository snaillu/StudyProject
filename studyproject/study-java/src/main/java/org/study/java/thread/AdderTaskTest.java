package org.study.java.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Phaser;

public class AdderTaskTest {
	public static void main(String[] args) {
		final int PHASE_COUNT=2;
		Phaser phaser = new Phaser(){

			@Override
			protected boolean onAdvance(int phase, int registeredParties) {
				System.out.println("Phase:"+ phase+", Arrived:"+this.getArrivedParties());
				boolean terminatePhaser = false;
				
				if(phase>=PHASE_COUNT-1||registeredParties==0){
					terminatePhaser = true;
				}
				return terminatePhaser;
			}
			
		};
		
		List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());
		
		final int ADDER_COUNT = 3;
		
		phaser.bulkRegister(ADDER_COUNT+1);
		
		for(int i=1;i<=ADDER_COUNT;i++){
			String taskName = "Task #"+i;
			AdderTask task = new AdderTask(taskName,phaser,list);
			task.start();
		}
		
		while(!phaser.isTerminated()){
			phaser.arriveAndAwaitAdvance();
		}
		
		int sum = 0;
		for(Integer num: list){
			sum = sum+num;
		}
		
		System.out.println("Sum="+sum);
	}
}
