package application;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import java.util.Date;
import org.eclipse.nebula.widgets.ganttchart.GanttChart;
import org.eclipse.nebula.widgets.ganttchart.GanttEvent;
import org.eclipse.nebula.widgets.ganttchart.GanttSection;
import org.eclipse.nebula.widgets.ganttchart.themes.ColorThemeGrayBlue;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import db.DB;
import model.entities.Tarefa;
import model.dao.impl.TarefaDaoJDBC;


/**
 * This snippet shows how to create layers, how to change the opacities for those layers, and also how to do showing/hiding of layers.
 * 
 */
public class GraphGantt {
	
	private static int currentLayer = 1;
	private static int minLayer = 1;
	private static int maxLayer = 3;
	
	private static Runnable runnable;
	
	@SuppressWarnings("rawtypes")
	public GraphGantt(String title, List<Tarefa> tarefas) {
		
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText(title);
		shell.setSize(600, 500);
		shell.setLayout(new FillLayout());

		// Create a chart
		final GanttChart ganttChart = new GanttChart(shell, SWT.NONE, null, new ColorThemeGrayBlue(), null, null);

		// Create some sections					
		GanttSection projeto = new GanttSection(ganttChart, "Project 01");
		List<GanttSection> projetos = new ArrayList<>();
		List<GanttEvent> eventos = new ArrayList<>();
		projetos.add(projeto);
		
		for(int i1 = 0; i1<tarefas.size();i1++) {
			
			String TaskName = tarefas.get(i1).getId() +"-"+ tarefas.get(i1).getTaskname();
//convertendo String >> Calendar:
			//data de inicio da tarefa:
			Calendar initialDate = Calendar.getInstance();
			Calendar finalDate = Calendar.getInstance();
			String[] startTask = tarefas.get(i1).getStarttime().split("/");			
			@SuppressWarnings("deprecation")
			Date startDate = new Date(Integer.parseInt(startTask[1])+"/"+//mes
									  Integer.parseInt(startTask[0])+"/"+//dia
									  Integer.parseInt(startTask[2]));	 //ano
			
			initialDate.setTime(startDate);	
			finalDate.setTime(startDate);
			
			initialDate.add(Calendar.DATE, 0);	
			finalDate.add(Calendar.DATE, Integer.parseInt(tarefas.get(i1).getDuration()));
											
//adicionando a tarefa no gráfico:							
			GanttEvent tarefa = new GanttEvent(ganttChart,TaskName,initialDate,finalDate, 0);
			projeto.addGanttEvent(tarefa);
			eventos.add(tarefa);		
		}								
		// move chart start date to the earliest event
		ganttChart.getGanttComposite().jumpToEarliestEvent();
		// Show chart
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())				
				display.sleep();		
		}		
		display.dispose();
		
		int saveChanges = JOptionPane.showConfirmDialog(null, "Salvar as alterações?", title, JOptionPane.YES_NO_OPTION);

		if (saveChanges == JOptionPane.YES_OPTION) {
//Usuário clicou em Sim. Executar o código correspondente.
			List<Tarefa> tarefasAtualizadas = new ArrayList<>();
//depois que fechamos a tela!
//			 			System.out.println("Id   Task Name   Start Time   End Time   Duration");
//listando as tarefas:			
			 			for(GanttEvent event: eventos) {
			 				
			 				Tarefa tarefaAtualizada = new Tarefa();		
			 				String [] idTask = event.getName().split("-");
			 				int id = Integer.parseInt(idTask[0]);
			 				String nameTask = idTask[1];
			 				
//https://www.geeksforgeeks.org/change-gregorian-calendar-to-simpledateformat-in-java/				
			 				SimpleDateFormat startDate = new SimpleDateFormat("dd/MM/yyyy");
			 				String startTask = startDate.format(event.getActualStartDate().getTime());							
			 				SimpleDateFormat endDate = new SimpleDateFormat("dd/MM/yyyy");
			 				String endTask = endDate.format(event.getActualEndDate().getTime());
//http://thiagocolen.blogspot.com/2016/01/java-diferenca-de-dias-entre-duas-datas.html
//https://www.educative.io/edpresso/how-to-convert-a-double-to-int-in-java
			 				System.out.println();
			 				long diferenca = event.getActualEndDate().getTime().getTime() 
			  						       - event.getActualStartDate().getTime().getTime();
			  			    String days = Long.toString(TimeUnit.MILLISECONDS.toDays(diferenca)).substring(0,1);	
			  			    tarefaAtualizada.setId(id);
			  				tarefaAtualizada.setTaskname(nameTask);
			  				tarefaAtualizada.setStarttime(startTask);
			  				tarefaAtualizada.setDuration(days);
			  				tarefasAtualizadas.add(tarefaAtualizada);	
//conecta o banco e atualiza as tarefas:
			  				TarefaDaoJDBC acess = new TarefaDaoJDBC(DB.getConnection()); 
			  		        acess.updateGantt(tarefaAtualizada);							
//			  				System.out.println(id+" "+nameTask +"   "+startTask+"   "+endTask+" "+ days);
			 			} 
		} 		
		else if (saveChanges == JOptionPane.NO_OPTION) {
		   
	  }
   }
}
	

		

	
	
